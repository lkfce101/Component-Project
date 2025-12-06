# Changelog

All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.1.0/),
and this project adheres to [Calendar Versioning](https://calver.org/) of
the following form: YYYY.0M.0D.

## 2025.12.05

### Added

- Designed test suite for CardDeck component
- Designed two different use cases for CardDeck component, one (CardDeckDemo) being a test demo that shows off the methods that can be performed on a carddeck and CardDeckGame being a guessing game built off of a carddeck.

### Notes

- Updated CardDeck1 to include the convention and correspondence parameters.
- General tidyness and clean up on multiple files.

## 2025.11.20

### Added

- Designed kernel implementation for `CardDeck` component
- Implemented all kernel and Standard methods (`add`, `add` with index, `remove`, `size`, `isEmpty`, `look`, `newInstance`, `clear`, `transferFrom`)
- Added constructor and `createNewRep()` method for initializing the representation
- (bonus) Edited CardDeck kernel and secondary to properly define and implement equals the correct way.

### Notes

- The representation chosen was a Sequence1L because it was the easiest aligned with carddeck allowing for easy implementation of the kernel methods.


## 2025.11.06

### Added
- Implemented CardDeckSecondary abstract class giving secondary (and object) method definitions using only the kernel methods.
- Added full implementations for
  - `void shuffle()`
  - `String drawOne()`
  - `String drawRand()`
  - `CardDeck drawCards(int i)`
  - `CardDeck viewCards(int i)`
  - `int locationOf(String card)`
  - `boolean contains(String card)`
  - `void swap(int i, int j)`
  - `String toString()`
  - `boolean equals(CardDeck c)`

### Notes
- The abstract class depends on the kernel implementation class that does not exist yet, which only causes a temporary issue in the equals method as it doesn't recognize CardDeck yet.


## 2025.10.23

### Added
- Created CardDeckKernel interface defining the set of kernel methods:
  - `add(String card)`
  - `add(String card, int index)`
  - `String remove(int index)`
  - `int size()`
  - `boolean isEmpty()`
  - `String look(int index)`

- Created CardDeck enhanced interface defining secondary methods:
  - `void shuffle()`
  - `String drawOne()`
  - `String drawRand()`
  - `CardDeck drawCards(int i)`
  - `CardDeck viewCards(int i)`
  - `int locationOf(String card)`
  - `boolean contains(String card)`
  - `void swap(int i, int j)`

### Notes
- Some methods have been renamed from previous iterations, drawMany became drawCards and viewTop became viewCards. Funcitonality did not change.



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


## 2025.09.19

### Added

- Brainstormed a Card Deck component
- Brainstormed a Music Playlist component
- Brainstormed a Dice roller/tracker component





