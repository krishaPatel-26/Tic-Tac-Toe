# Tic-Tac-Toe

A Java-based Tic-Tac-Toe game featuring multiple player modes, AI opponents, and both classic and extended game versions.

## 🎯 Features

### **Project 1: Classic 3×3 Version**
- **5 Game Modes**: Human vs Human, Human vs Computer (Random), Human vs Computer (Smart), Computer vs Computer combinations
- **Smart AI Strategy**: Wins if possible, blocks opponent, takes strategic positions
- **Interactive Console Interface**: Clean board display and player turns

### **Project 2: Extended N×N Version**
- **Customizable Board Size**: Play on boards from 3×3 to 20×20
- **Adjustable Win Condition**: Set how many in a row needed to win
- **Backward Compatibility**: Reuses original game logic with extended features

## 🎮 Game Modes

### Project 1:
1. **Human vs Human** - Two players take turns
2. **Human vs Computer (Random)** - Player vs random AI
3. **Human vs Computer (Smart)** - Player vs strategic AI
4. **Computer (Random) vs Computer (Smart)** - AI battle
5. **Computer (Smart) vs Computer (Smart)** - Smart AI showdown

### Project 2:
1. **Human vs Human** - Classic two-player mode
2. **Human vs Computer (Random)** - Player vs basic AI
3. **Human vs Computer (Smart)** - Player vs strategic AI
4. **Computer vs Computer** - Watch AI battle

## 🧠 AI Features
- **Smart Strategy**: Checks for wins, blocks opponents, prioritizes center and corners
- **Random Strategy**: Makes random valid moves
- **Adaptive Play**: Works with any board size in the extended version

## 🚀 Getting Started

### **Run Project 1 (Classic 3×3):**
```bash
cd Project1
javac *.java
java Main
```

### **Run Project 2 (Extended N×N):**
```bash
cd Project2
javac *.java
java ExtendedMain
```

## 📊 How to Play
1. **Select game mode** from the menu
2. **Enter moves** as row and column (e.g., "1 2" for row 1, column 2)
3. **Try to get 3 in a row** (or custom number in Project 2)
4. **Win by**: Getting your symbol in a complete line horizontally, vertically, or diagonally

## 🎨 Design Features
- **Strategy Pattern** for different AI behaviors
- **Clean separation** of game logic and user interface
- **Input validation** prevents crashes
- **Color-coded console output** for better readability

*Test your strategy against increasingly challenging AI opponents!* 🎮✨
