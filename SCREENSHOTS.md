# App Screenshots and Visual Guide

## App Flow

### 1. Initial State
When the app first launches, the user sees:
- **Title**: "Taş Kağıt Makas" in primary color
- **Score Board**: Both scores at 0:0
- **Instructions**: "Hamlenizi Seçin" (Choose your move)
- **Three Buttons**: Rock (🪨 Taş), Paper (📄 Kağıt), Scissors (✂️ Makas)
- No choices or results displayed yet

```
Initial Screen:
┌─────────────────────────────┐
│   🎮 Taş Kağıt Makas       │
│                             │
│  ┌───────────────────────┐ │
│  │   Sen   :  Bilgisayar │ │
│  │    0         0        │ │
│  └───────────────────────┘ │
│                             │
│                             │
│   Hamlenizi Seçin          │
│                             │
│  [🪨 Taş] [📄 Kağıt] [✂️ Makas] │
│                             │
└─────────────────────────────┘
```

### 2. Player Makes a Choice
User taps "Makas" (Scissors):
- Phone vibrates (haptic feedback)
- Buttons are disabled
- Player's choice animates in at the bottom
- Computer is "thinking" (300ms delay)

```
After Player Choice:
┌─────────────────────────────┐
│   🎮 Taş Kağıt Makas       │
│                             │
│  ┌───────────────────────┐ │
│  │   Sen   :  Bilgisayar │ │
│  │    0         0        │ │
│  └───────────────────────┘ │
│                             │
│  [Animation: Appearing...]  │
│                             │
│  ┌─────────────────────┐   │
│  │       ✂️            │   │
│  │      Makas          │   │
│  │       Sen           │   │
│  └─────────────────────┘   │
│                             │
│   Hamlenizi Seçin          │
│  [Disabled] [Disabled] [Disabled] │
└─────────────────────────────┘
```

### 3. Computer's Choice Revealed
After 300ms:
- Computer's choice animates in at the top
- Shows "Kağıt" (Paper) in this example
- Another 300ms delay before showing result

```
Computer Choice Shown:
┌─────────────────────────────┐
│   🎮 Taş Kağıt Makas       │
│                             │
│  ┌───────────────────────┐ │
│  │   Sen   :  Bilgisayar │ │
│  │    0         0        │ │
│  └───────────────────────┘ │
│                             │
│  ┌─────────────────────┐   │
│  │   Bilgisayar        │   │
│  │       📄            │   │
│  │      Kağıt          │   │
│  └─────────────────────┘   │
│                             │
│  [Animation: Calculating...] │
│                             │
│  ┌─────────────────────┐   │
│  │       ✂️            │   │
│  │      Makas          │   │
│  │       Sen           │   │
│  └─────────────────────┘   │
│                             │
│   Hamlenizi Seçin          │
│  [Disabled] [Disabled] [Disabled] │
└─────────────────────────────┘
```

### 4. Result Displayed
Result animates in with color:
- Paper beats Scissors
- Player loses this round
- Score updates: Computer gets a point (0:1)
- "Yeni Oyun" button appears
- Game buttons re-enabled

```
Result Shown (Player Loses):
┌─────────────────────────────┐
│   🎮 Taş Kağıt Makas       │
│                             │
│  ┌───────────────────────┐ │
│  │   Sen   :  Bilgisayar │ │
│  │    0         1        │ │ ← Score Updated
│  └───────────────────────┘ │
│                             │
│  ┌─────────────────────┐   │
│  │   Bilgisayar        │   │
│  │       📄            │   │
│  │      Kağıt          │   │
│  └─────────────────────┘   │
│                             │
│  ┌─────────────────────┐   │
│  │   Kaybettin 😢      │   │ ← Red Container
│  └─────────────────────┘   │
│                             │
│  ┌─────────────────────┐   │
│  │       ✂️            │   │
│  │      Makas          │   │
│  │       Sen           │   │
│  └─────────────────────┘   │
│                             │
│   Hamlenizi Seçin          │
│  [🪨 Taş] [📄 Kağıt] [✂️ Makas] │
│                             │
│  [    Yeni Oyun     ]      │ ← Reset Button
└─────────────────────────────┘
```

### 5. Win Scenario
When player wins:
- Result card is green (primary container)
- Shows "Kazandın! 🎉"
- Player score increases

```
Win State:
┌─────────────────────────────┐
│   🎮 Taş Kağıt Makas       │
│                             │
│  ┌───────────────────────┐ │
│  │   Sen   :  Bilgisayar │ │
│  │    1         1        │ │
│  └───────────────────────┘ │
│                             │
│  ┌─────────────────────┐   │
│  │   Bilgisayar        │   │
│  │       ✂️            │   │
│  │      Makas          │   │
│  └─────────────────────┘   │
│                             │
│  ┌─────────────────────┐   │
│  │   Kazandın! 🎉      │   │ ← Green Container
│  └─────────────────────┘   │
│                             │
│  ┌─────────────────────┐   │
│  │       🪨            │   │
│  │       Taş           │   │
│  │       Sen           │   │
│  └─────────────────────┘   │
│                             │
│   Hamlenizi Seçin          │
│  [🪨 Taş] [📄 Kağıt] [✂️ Makas] │
│                             │
│  [    Yeni Oyun     ]      │
└─────────────────────────────┘
```

### 6. Draw Scenario
When it's a draw:
- Result card is neutral (secondary container)
- Shows "Berabere! 🤝"
- No score change

```
Draw State:
┌─────────────────────────────┐
│   🎮 Taş Kağıt Makas       │
│                             │
│  ┌───────────────────────┐ │
│  │   Sen   :  Bilgisayar │ │
│  │    2         1        │ │
│  └───────────────────────┘ │
│                             │
│  ┌─────────────────────┐   │
│  │   Bilgisayar        │   │
│  │       📄            │   │
│  │      Kağıt          │   │
│  └─────────────────────┘   │
│                             │
│  ┌─────────────────────┐   │
│  │   Berabere! 🤝      │   │ ← Neutral Container
│  └─────────────────────┘   │
│                             │
│  ┌─────────────────────┐   │
│  │       📄            │   │
│  │      Kağıt          │   │
│  │       Sen           │   │
│  └─────────────────────┘   │
│                             │
│   Hamlenizi Seçin          │
│  [🪨 Taş] [📄 Kağıt] [✂️ Makas] │
│                             │
│  [    Yeni Oyun     ]      │
└─────────────────────────────┘
```

### 7. After Reset
Clicking "Yeni Oyun" button:
- Scores reset to 0:0
- All choices and result disappear
- Buttons remain enabled
- Back to initial state

## Color Variations

### Light Theme
- Background: White/Light gray
- Primary buttons: Purple tones
- Cards: Soft colored containers
- Text: Dark on light

### Dark Theme
- Background: Dark gray/Black
- Primary buttons: Light purple tones
- Cards: Elevated dark surfaces
- Text: Light on dark

### Dynamic Colors (Android 12+)
- Adapts to wallpaper colors
- Maintains accessibility
- Smooth color transitions

## Animation Details

### Spring Animations
- **Entry**: Objects bounce slightly when appearing
- **Exit**: Objects shrink and fade when disappearing
- **Duration**: ~300-500ms per animation
- **Feel**: Natural and playful

### Haptic Feedback
- **Trigger**: On button press
- **Duration**: 50ms
- **Type**: Single short vibration
- **Intensity**: Default amplitude

## Interactive Elements

### Buttons
- **Idle**: Standard Material 3 appearance
- **Pressed**: Ripple effect + haptic feedback
- **Disabled**: Faded appearance during game play
- **Size**: Large enough for comfortable tapping

### Cards
- **Elevation**: Slight shadow for depth
- **Corners**: Rounded for modern look
- **Colors**: Semantic (green=win, red=lose, gray=draw)
- **Animation**: Smooth scale-in effect

## Typography

All text is clear and readable:
- **Title**: Large, bold, primary color
- **Scores**: Very large numbers, easy to read at a glance
- **Labels**: Medium size, good contrast
- **Buttons**: Clear, appropriately sized

## Spacing

Generous spacing throughout:
- Easy to read and scan
- No cramped elements
- Comfortable tap targets
- Balanced composition

## Accessibility

- ✅ Large touch targets (120dp buttons)
- ✅ High contrast text
- ✅ Clear visual hierarchy
- ✅ Descriptive content descriptions
- ✅ Supports system font scaling
- ✅ Works with screen readers

## Edge Cases

### Rapid Tapping
- Buttons disabled during game
- Prevents multiple simultaneous games

### Orientation Change
- State preserved
- Layout adapts

### Theme Change
- Smooth transition
- All elements update properly

## User Experience Flow

```
Launch → See Initial State
  ↓
Tap Choice → Haptic Feedback
  ↓
See Your Choice → Animate In (300ms)
  ↓
See Computer Choice → Animate In (300ms)
  ↓
See Result → Color-Coded Card
  ↓
Score Updates → Instant
  ↓
Either:
  - Tap Another Choice → New Round
  - Tap "Yeni Oyun" → Reset Scores
```

Total time per round: ~600ms + user decision time

This creates a fast, responsive, and engaging game experience!
