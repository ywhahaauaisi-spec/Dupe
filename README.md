# Dupe Mod for Minecraft 1.21.1

A Fabric mod that adds a `/dupe` command to duplicate items in your hand.

## Features
- Use `/dupe` to duplicate the item you're holding
- Preserves enchantments, custom names, and NBT data
- Real duplication (not visual)
- Automatically drops items if inventory is full

## Building

### On Desktop:
```bash
./gradlew build
```

### On Mobile (Termux):
```bash
pkg install openjdk-21 gradle git
git clone <repo-url>
cd Dupe
gradle build
```

The compiled mod will be at `build/libs/dupe-mod-1.0.0.jar`

## Installation

1. Install Fabric Loader for 1.21.1
2. Place the JAR file in your `.minecraft/mods` folder
3. Launch Minecraft with the Fabric profile

## Usage

In-game:
```
/dupe
```

Duplicates whatever you're holding in your main hand.