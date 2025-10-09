# Changelog

All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.1.0/),
and this project adheres to [Calendar Versioning](https://calver.org/) of
the following form: YYYY.0M.0D.

## 2025.09.19

### Added

- Brainstormed a Card Deck component
- Brainstormed a Music Playlist component
- Brainstormed a Dice roller/tracker component


## 2025.10.09

### Added
- Implemented proof-of-concept for `CardDeck` component
- Added kernel methods:
  - `add(String card)`
  - `add(String card, int index)`
  - `remove(int index)`
  - `size()`
- Added secondary methods:
  - `shuffle()` — randomizes order of cards in this
  - `drawOne()` — removes and returns the top card
  - `drawMany(int i)` — removes and returns the first *i* cards as a new deck
- Implemented `toString()` to output the contents of the deck
- Added `main` method with a working demonstration

### Notes
- This proof confirms feasibility of a `CardDeck` component.
- This is just an outline in one class, things will get separated out later.


