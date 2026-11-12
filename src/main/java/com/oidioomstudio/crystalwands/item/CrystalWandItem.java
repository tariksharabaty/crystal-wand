package com.oidioomstudio.crystalwands.item;

import com.oidioomstudio.crystalwands.config.CrystalWandsConfig;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ProjectileUtil;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.Vec3;

import java.util.List;

public class CrystalWandItem extends Item {
    private final int tier;

    public CrystalWandItem(Item.Properties properties, int tier) {
        super(properties);
        this.tier = tier;
    }

    public int getTier() {
        return tier;
    }

    @Override
    public InteractionResult use(Level level, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);

        if (player.getCooldowns().isOnCooldown(stack)) {
            return InteractionResult.FAIL;
        }

        CrystalWandsConfig.Data cfg = CrystalWandsConfig.get();

        if (level.isClientSide()) {
            return InteractionResult.SUCCESS;
        }

        ServerLevel serverLevel = (ServerLevel) level;
        Vec3 eyePos = player.getEyePosition();
        Vec3 lookVec = player.getViewVector(1.0F);

        int cooldown;

        switch (this.tier) {
            case 1 -> {
                cooldown = cfg.cooldownTier1;

                if (cfg.enableSoundEffects) {
                    level.playSound(null, player.getX(), player.getY(), player.getZ(),
                            SoundEvents.AMETHYST_BLOCK_CHIME, SoundSource.PLAYERS, 1.2F, 1.5F);
                }

                if (cfg.enableParticleEffects) {
                    serverLevel.sendParticles(ParticleTypes.END_ROD,
                            eyePos.x + lookVec.x, eyePos.y + lookVec.y, eyePos.z + lookVec.z,
                            12, 0.2, 0.2, 0.2, 0.05);
                }

                // Tier 1: Brief agility surge
                player.addEffect(new MobEffectInstance(MobEffects.SPEED, 60, 0, false, false, true));
            }
            case 2 -> {
                cooldown = cfg.cooldownTier2;

                if (cfg.enableSoundEffects) {
                    level.playSound(null, player.getX(), player.getY(), player.getZ(),
                            SoundEvents.AMETHYST_BLOCK_RESONATE, SoundSource.PLAYERS, 1.3F, 1.2F);
                    level.playSound(null, player.getX(), player.getY(), player.getZ(),
                            SoundEvents.EXPERIENCE_ORB_PICKUP, SoundSource.PLAYERS, 0.8F, 1.6F);
                }

                // Tier 2: Radiant ray up to 18 blocks
                double rayRange = 18.0;
                Vec3 endPos = eyePos.add(lookVec.scale(rayRange));
                AABB searchBox = player.getBoundingBox().expandTowards(lookVec.scale(rayRange)).inflate(1.5);
                EntityHitResult hit = ProjectileUtil.getEntityHitResult(player, eyePos, endPos, searchBox,
                        entity -> entity instanceof LivingEntity && !entity.isAlliedTo(player), rayRange * rayRange);

                if (hit != null && hit.getEntity() instanceof LivingEntity target) {
                    target.hurtServer(serverLevel, player.damageSources().magic(), (float) cfg.tier2Damage);
                    target.addEffect(new MobEffectInstance(MobEffects.GLOWING, 100, 0, false, false, true));
                    target.push(lookVec.x * 0.8, 0.3, lookVec.z * 0.8);

                    if (cfg.enableParticleEffects) {
                        serverLevel.sendParticles(ParticleTypes.ENCHANT,
                                target.getX(), target.getY() + target.getBbHeight() / 2, target.getZ(),
                                15, 0.3, 0.3, 0.3, 0.1);
                    }
                }

                if (cfg.enableParticleEffects) {
                    for (int i = 1; i <= 12; i++) {
                        Vec3 p = eyePos.add(lookVec.scale(i * (rayRange / 12.0)));
                        serverLevel.sendParticles(ParticleTypes.GLOW, p.x, p.y, p.z, 2, 0.05, 0.05, 0.05, 0.01);
                    }
                }
            }
            case 3 -> {
                cooldown = cfg.cooldownTier3;

                if (cfg.enableSoundEffects) {
                    level.playSound(null, player.getX(), player.getY(), player.getZ(),
                            SoundEvents.AMETHYST_CLUSTER_HIT, SoundSource.PLAYERS, 1.5F, 0.8F);
                    level.playSound(null, player.getX(), player.getY(), player.getZ(),
                            SoundEvents.CONDUIT_ACTIVATE, SoundSource.PLAYERS, 1.2F, 1.4F);
                }

                // Tier 3: Ancient Might - Prism blast & shockwave
                double maxRange = 28.0;
                AABB blastBox = player.getBoundingBox().expandTowards(lookVec.scale(maxRange)).inflate(2.0);

                List<LivingEntity> nearbyTargets = level.getEntitiesOfClass(LivingEntity.class, blastBox,
                        e -> e != player && !e.isAlliedTo(player));

                for (LivingEntity target : nearbyTargets) {
                    Vec3 toTarget = target.position().subtract(player.position()).normalize();
                    double dot = lookVec.dot(toTarget);
                    if (dot > 0.65) { // Within frontal cone
                        target.hurtServer(serverLevel, player.damageSources().playerAttack(player), (float) cfg.tier3Damage);
                        target.push(toTarget.x * 1.2, 0.4, toTarget.z * 1.2);

                        if (cfg.enableParticleEffects) {
                            serverLevel.sendParticles(ParticleTypes.EXPLOSION,
                                    target.getX(), target.getY() + target.getBbHeight() / 2, target.getZ(),
                                    1, 0, 0, 0, 0);
                        }
                    }
                }

                // Protective Ancient Aura for player
                player.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, 160, 1, false, false, true));
                player.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 80, 0, false, false, true));

                if (cfg.enableParticleEffects) {
                    for (int i = 1; i <= 20; i++) {
                        Vec3 p = eyePos.add(lookVec.scale(i * (maxRange / 20.0)));
                        serverLevel.sendParticles(ParticleTypes.END_ROD, p.x, p.y, p.z, 3, 0.08, 0.08, 0.08, 0.02);
                        serverLevel.sendParticles(ParticleTypes.ENCHANT, p.x, p.y, p.z, 2, 0.05, 0.05, 0.05, 0.02);
                    }
                }
            }
            default -> cooldown = 20;
        }

        player.getCooldowns().addCooldown(stack, cooldown);
        return InteractionResult.SUCCESS;
    }
}
