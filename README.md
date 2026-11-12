<p align="center"><img src=".github/assets/icon.png" width="96" alt="🔮 Crystal Wands"></p>

<h1 align="center">🔮 Crystal Wands</h1>

<p align="center"><b>An impractical, yet exquisite wand.</b></p>

<p align="center">
  <img src="https://img.shields.io/badge/version-1.1.2-0A7BBB?style=flat-square&labelColor=555555" alt="version 1.1.2">
  <img src="https://img.shields.io/badge/Minecraft-26.3-62B47A?style=flat-square&labelColor=555555" alt="Minecraft 26.3">
  <img src="https://img.shields.io/badge/loader-Fabric-DBD0B4?style=flat-square&labelColor=38342A" alt="loader Fabric">
  <img src="https://img.shields.io/badge/Java-25-E76F00?style=flat-square&labelColor=555555&logo=openjdk&logoColor=white" alt="Java 25">
  <img src="https://img.shields.io/badge/license-MIT-F1C40F?style=flat-square&labelColor=555555" alt="license MIT">
  <a href="https://github.com/tariksharabaty/o-lib"><img src="https://img.shields.io/badge/requires-O%20Lib-8957E5?style=flat-square&labelColor=555555" alt="requires O Lib"></a>
  <a href="https://modrinth.com/organization/oidioomstudio"><img src="https://img.shields.io/badge/Modrinth-Oidioom%20Studio-1BD96A?style=flat-square&labelColor=555555&logo=modrinth&logoColor=white" alt="Modrinth Oidioom Studio"></a>
  <a href="https://oidioom.com"><img src="https://img.shields.io/badge/by-Oidioom-0D1117?style=flat-square&labelColor=555555" alt="by Oidioom"></a>
</p>

<p align="center"><a href="#-english">🇬🇧 English</a> · <a href="#-türkçe">🇹🇷 Türkçe</a></p>

---

## 🇬🇧 English

> [!IMPORTANT]
> Requires **[O Lib](https://github.com/tariksharabaty/o-lib)** and **Fabric API**.

**Crystal Wands** introduces 3 tiers of mystical crystal wands crafted with precision and attuned to ancient resonances. Each wand boasts custom sound effects, enchanting particle spirals, and impactful magical abilities designed for survival utility and combat mastery.

---

## ✨ The 3 Tiers of Crystal Wands

### 🌟 Crystal Wand I (Uncommon)
- **Ability:** *Agility Surge*
- **Effect:** Right-click to channel a swift burst of crystal resonance. Grants **Speed I** for 3 seconds while unleashing an amethyst chime and glistening End Rod sparkles.
- **Cooldown:** 1.25 seconds (configurable).

### 💎 Crystal Wand II (Rare) — *Radiant Elegance*
- **Ability:** *Radiant Piercing Ray*
- **Effect:** Casts an 18-block piercing ray of resonant energy in your line of sight:
  - Deals **6.0 magical damage** to enemies hit.
  - Knocks back targets and applies the **Glowing** effect for 5 seconds to track them through walls.
  - Plays resonant chime and crystal pickup audio.
- **Cooldown:** 2.25 seconds (configurable).

### 👑 Crystal Wand III (Epic) — *Ancient Might*
- **Ability:** *Prism Blast & Ancient Aura*
- **Effect:** Unleashes the pinnacle of crystal sorcery:
  - Channels a 28-block wide frontal **shockwave cone** dealing **12.0 damage** and launching hostile mobs away with violent force and explosive particles!
  - Grants the caster an **Ancient Protective Aura**: **Absorption II** (8 seconds) and **Regeneration I** (4 seconds).
  - Resonates with deep conduit & amethyst cluster sonic hits.
- **Cooldown:** 3.5 seconds (configurable).

---

## ⚙️ In-Game Configuration (Stone UI)

Powered by **O Lib**, you can customize every aspect live in-game:
- **Cooldown Sliders:** Fine-tune the cooldown (in ticks) for Tier I, Tier II, and Tier III wands independently.
- **Damage Scaling:** Adjust Tier II and Tier III blast damage to suit your modpack's balance.
- **Audio & Visual Toggles:** Toggle particle and sound effects.

---

## 📥 Installation

1. Install **Minecraft 26.3** with **Fabric Loader**.
2. Install **Fabric API**.
3. Install **O Lib** (required core library).
4. Drop `crystal-wand-1.1.2-mc26.3.jar` into your `mods` folder.

---

## ⬇️ Download

- **Modrinth:** [Oidioom Studio](https://modrinth.com/organization/oidioomstudio)
- **GitHub Releases:** [`crystal-wand-1.1.2-mc26.3.jar`](../../releases/latest)

## 🔨 Building from source

Requires **JDK 25**.

```bash
# 1) O Lib is a dependency — publish it to your local Maven first
git clone https://github.com/tariksharabaty/o-lib.git
(cd o-lib && ./gradlew publishToMavenLocal)

# 2) build this mod
./gradlew build
# output: build/libs/crystal-wand-1.1.2-mc26.3.jar
```

## 📄 License

[MIT](LICENSE) © 2026 Oidioom / Tarek Sharabaty

---

## 🇹🇷 Türkçe

**"Pratik değil ama muhteşem bir asa." Ametist ve kristal büyüsünü 3 kademeli asayla kullanın.**

> [!IMPORTANT]
> **[O Lib](https://github.com/tariksharabaty/o-lib)** ve **Fabric API** gerektirir.

### ✨ Özellikler

- 3 kademeli kristal asa (I, II, III)
- Özel 3D modeller ve kristal efektleri
- O Lib Taş Arayüzü ile oyun içi ayarlar

### 📥 Kurulum

1. **Minecraft 26.3** için **Fabric Loader** kurun.
2. **Fabric API** ve **O Lib** modlarını `mods` klasörüne ekleyin.
3. `crystal-wand-1.1.2-mc26.3.jar` dosyasını `mods` klasörüne atın ve oyunu başlatın.

### ⬇️ İndir

- **Modrinth:** [Oidioom Studio](https://modrinth.com/organization/oidioomstudio)
- **GitHub Releases:** [`crystal-wand-1.1.2-mc26.3.jar`](../../releases/latest)

### 📄 Lisans

[MIT](LICENSE) © 2026 Oidioom / Tarek Sharabaty

---

<p align="center"><a href="https://oidioom.com"><picture><source media="(prefers-color-scheme: dark)" srcset=".github/assets/oidioom-dark.svg"><img src=".github/assets/oidioom-light.svg" width="40" alt="Oidioom"></picture></a></p>
<p align="center"><b>by Oidioom — Tarek Sharabaty</b><br>
<a href="https://oidioom.com">oidioom.com</a> · <a href="https://github.com/tariksharabaty">GitHub</a> · <a href="https://modrinth.com/organization/oidioomstudio">Modrinth</a> · <a href="https://gear.oidioom.com">Gear</a> · <a href="https://www.instagram.com/oidioom">Instagram</a></p>
