# Changelog
All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](http://keepachangelog.com/en/1.0.0/) and this project adheres to [this versioning scheme](https://gist.github.com/cech12/69319028e88c50349a6b044000a6607b).

## [1.21.4-4.3.0.0] - 2026-04-17
### Changed
- Updated to Minecraft 1.21.4 (Fabric 0.116.0+1.21.4, NeoForge 21.4.157)
- Updated BucketLib to 1.21.4-4.3.0.1
- Updated Cloth Config support (17.0.144) (Fabric/Quilt)
- Updated ModMenu support (13.0.3) (Fabric/Quilt)

## [1.21.3-4.2.1.0] - 2025-07-15
### Added
- Added Hungarian translation (thanks to bayi for the contribution) #31

## [1.21.3-4.2.0.0] - 2025-01-29
### Changed
- Updated to Minecraft 1.21.3 (Fabric 0.107.0+1.21.3, Neoforge 21.3.56)
- (Forge support is still not available until the capability system is re-added)
- Updated BucketLib to 1.21.3-4.2.0.4
- Updated Cloth Config support (16.0.141) (Fabric/Quilt)
- Updated ModMenu support (12.0.0) (Fabric/Quilt)

## [1.21-4.1.1.0] - 2024-08-30
### Changed
- number config options are now text fields instead of sliders (Fabric)

## [1.21-4.1.0.0] - 2024-07-14
### Changed
- updated NeoForge to 21.0.94-beta
- updated BucketLib to 1.21-4.1.0.0
- the `config` directory is used for the default configuration (NeoForge)

### Fixed
- crashed on startup with NeoForge (caused by a breaking change in 21.0.82-beta)

## [1.21-4.0.0.0] - 2024-06-21
### Changed
- Updated to Minecraft 1.21 (Fabric 0.100.3+1.21, Neoforge 21.0.20-beta)
- (Forge support is still not available until the capability system is re-added)
- Updated BucketLib to 1.21-4.0.0.1
- Updated Cloth Config support (15.0.127) (Fabric/Quilt)
- Updated ModMenu support (11.0.0) (Fabric/Quilt)

## [1.20.6-3.3.0.0] - 2024-06-20
### Changed
- Updated to Minecraft 1.20.6 (Fabric 0.98.0+1.20.6, Neoforge 20.6.119)
- Removed Forge support until the capability system is re-added
- Updated BucketLib to 1.20.6-3.3.0.3
- Updated Cloth Config support (14.0.126) (Fabric/Quilt)
- Updated ModMenu support (10.0.0-beta.1) (Fabric/Quilt)

### Fixed
- fixed known issue: max stack size was not taken into account and defaulted to 1 (Fabric)

## [1.20.4-3.2.0.0] - 2024-05-11
### Added
- add Fabric (>=0.96.11+1.20.4) support (Fabric, Quilt)

### Changed
- updated BucketLib to 1.20.4-3.2.0.2
- changed the config descriptions to be more precisely

### Known issues
- Fabric: max stack size of 16 is not taken into account and defaults to 1

## [1.20.4-3.1.0.2] - 2024-02-26
### Fixed
- fixed some config issues caused by copy-paste-errors
- renamed config "ceramicBucketBreakTemperature" to former "crackingTemperature"
- reset default durability to 25

## [1.20.4-3.1.0.1] - 2024-02-12
### Fixed
- startup crash when started in Forge environment was fixed

## [1.20.4-3.1.0.0] - 2024-01-29
### Changed
- Update to Minecraft 1.20.4 (Forge 49.0.22, Neoforge 20.4.138-beta)
- Update BucketLib to 1.20.4-3.1.0.0

## [1.20.2-3.0.0.0] - 2024-01-03
### Changed
- Move to Multiloader mod template to support Forge and Neoforge
- Update to Forge 48.1.0 & Neoforge 20.2.86
- Update BucketLib to 1.20.2-3.0.0.4

## [1.20.2-2.2.0.0] - 2023-10-16
### Changed
- update and move back to Forge 1.20.2-48.0.23 (from NeoForge) until it is stable

## [1.20.1-2.1.0.0] - 2023-08-09
### Changed
- Changed Forge to NeoForge 1.20.1-47.1.54 (compatible with Forge 47.1.0)
- Updated BucketLib mod to 1.20.1-2.3.0.0

## [1.20.1-2.0.1.0] - 2023-06-14
### Changed
- Update BucketLib mod to 1.20.1-2.1.0.0

## [1.20.1-2.0.0.0] - 2023-06-14
### Changed
- Update to Forge 1.20.1-47.0.1 #10
- Update BucketLib mod to 1.20-2.0.0.0 #10

## [1.19.3-1.2.0.1] - 2023-02-05
### Changed
- Added pt_br and pt_pt translations #9 (thanks to sanduicheirainox)

## [1.19.3-1.2.0.0] - 2023-01-02
### Changed
- Update to Forge 1.19.3-44.0.41
- Update BucketLib mod to 1.19.3-1.1.0.0

## [1.19-1.1.0.0] - 2022-07-06
### Changed
- Update to Forge 1.19-41.0.62 #4
- Update BucketLib mod to 1.19-1.0.0.0 #4

## [1.18.2-1.0.2.1] - 2022-05-17
### Added
- language support for Simplified Chinese (thanks to CJYKK)

## [1.18.2-1.0.2.0] - 2022-05-15
### Changed
- Update to Forge 1.18.2-40.0.18
- Update BucketLib mod to 1.18.2-0.5.3.2

## [1.18.2-1.0.1.0] - 2022-03-03
### Changed
- Update to Forge 1.18.2-40.0.2
- Update BucketLib mod to 1.18.2-0.5.1.0

## [1.18.1-1.0.0.0] - 2022-03-02
### Added
- Wooden Bucket with durability of 25 and burning & freezing effect
