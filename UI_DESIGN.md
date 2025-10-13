# UI Design Documentation - Taş Kağıt Makas

## Screen Layout

The game uses a single-screen layout with a vertical structure:

```
┌─────────────────────────────────────┐
│                                     │
│     🎮 Taş Kağıt Makas             │  ← Title (Primary Color)
│                                     │
│  ┌─────────────────────────────┐   │
│  │       Skor Tablosu          │   │  ← Score Card
│  │                             │   │  (Secondary Container)
│  │    Sen    :   Bilgisayar    │   │
│  │     3          2            │   │
│  └─────────────────────────────┘   │
│                                     │
│  ┌─────────────────────────────┐   │
│  │       Bilgisayar            │   │  ← Computer Choice
│  │          📄                  │   │  (Tertiary Container)
│  │         Kağıt               │   │  (Animated entry)
│  └─────────────────────────────┘   │
│                                     │
│  ┌─────────────────────────────┐   │
│  │                             │   │  ← Result Card
│  │      Kazandın! 🎉          │   │  (Primary/Error/
│  │                             │   │   Secondary Container)
│  └─────────────────────────────┘   │
│                                     │
│  ┌─────────────────────────────┐   │
│  │          ✂️                  │   │  ← Player Choice
│  │         Makas               │   │  (Primary Container)
│  │          Sen                │   │  (Animated entry)
│  └─────────────────────────────┘   │
│                                     │
│     Hamlenizi Seçin                 │
│                                     │
│  ┌────┐  ┌────┐  ┌────┐           │
│  │ 🪨 │  │ 📄 │  │ ✂️ │           │  ← Choice Buttons
│  │Taş │  │Kağıt│  │Makas│          │  (Filled Tonal)
│  └────┘  └────┘  └────┘           │
│                                     │
│  ┌─────────────────────────────┐   │
│  │       Yeni Oyun             │   │  ← Reset Button
│  └─────────────────────────────┘   │  (Outlined)
│                                     │
└─────────────────────────────────────┘
```

## Color Scheme

### Light Theme
- **Background**: Material 3 Light Background
- **Primary**: Purple40 (#6650a4)
- **Secondary**: PurpleGrey40 (#625b71)
- **Tertiary**: Pink40 (#7D5260)

### Dark Theme
- **Background**: Material 3 Dark Background
- **Primary**: Purple80 (#D0BCFF)
- **Secondary**: PurpleGrey80 (#CCC2DC)
- **Tertiary**: Pink80 (#EFB8C8)

### Dynamic Colors (Android 12+)
Automatically adapts to system wallpaper colors

## Component Breakdown

### 1. Title Section
- **Typography**: HeadlineLarge
- **Color**: Primary
- **Font Weight**: Bold
- **Alignment**: Center

### 2. Score Board Card
- **Component**: Card with SecondaryContainer
- **Layout**: Row with SpaceEvenly
- **Player Score**: DisplayMedium, Bold, Primary
- **Computer Score**: DisplayMedium, Bold, Primary
- **Labels**: LabelLarge, OnSecondaryContainer
- **Separator**: ":" in DisplayMedium

### 3. Computer Choice Display
- **Component**: AnimatedVisibility + Card
- **Animation**: ScaleIn + FadeIn with Spring
- **Container Color**: TertiaryContainer
- **Icon Size**: 64dp
- **Label**: TitleMedium, OnTertiaryContainer
- **Padding**: 24dp

### 4. Result Display
- **Component**: AnimatedVisibility + Card
- **Colors**:
  - Win: PrimaryContainer (Green tones)
  - Lose: ErrorContainer (Red tones)
  - Draw: SecondaryContainer (Neutral tones)
- **Typography**: HeadlineMedium, Bold
- **Text Alignment**: Center
- **Emojis**: 🎉 (Win), 😢 (Lose), 🤝 (Draw)

### 5. Player Choice Display
- **Component**: AnimatedVisibility + Card
- **Animation**: ScaleIn + FadeIn with Spring
- **Container Color**: PrimaryContainer
- **Icon Size**: 64dp
- **Label**: TitleMedium, OnPrimaryContainer
- **Padding**: 24dp

### 6. Choice Buttons
- **Component**: FilledTonalButton
- **Layout**: Row with 12dp spacing
- **Height**: 120dp
- **Icon Size**: 48dp
- **Typography**: LabelLarge
- **Weight**: Equal (1f each)
- **State**: Disabled during game play

### 7. Reset Button
- **Component**: OutlinedButton
- **Width**: fillMaxWidth
- **Visibility**: Only when game result exists

## Animations

### Entry Animations
1. **Computer/Player Choice**
   - Type: ScaleIn + FadeIn
   - Spring: MediumBouncy damping, Low stiffness
   - Duration: ~300ms

2. **Result Display**
   - Type: ScaleIn + FadeIn
   - Spring: MediumBouncy damping, Low stiffness
   - Timing: After computer choice appears

### Exit Animations
- Type: ScaleOut + FadeOut
- Used when starting new round

### Button Interactions
- Haptic feedback: 50ms vibration
- Visual state changes via Material 3
- Disabled state during game play

## Spacing & Layout

### Vertical Spacing
- Title to Score: 24dp
- Score to Computer Choice: 32dp
- Computer to Result: 32dp
- Result to Player: 32dp
- Player to Instructions: 16dp
- Instructions to Buttons: 16dp
- Buttons to Reset: 16dp

### Horizontal Spacing
- Screen padding: 24dp
- Button spacing: 12dp

### Card Padding
- Score board: 16dp
- Choice cards: 24dp
- Result card: 24dp

## Typography Scale

- **HeadlineLarge**: Game title
- **DisplayMedium**: Scores
- **HeadlineMedium**: Result message
- **TitleMedium**: Choice labels, section labels
- **LabelLarge**: Button text, small labels

## Icon Design

### Rock (🪨)
- Style: Fist/closed hand shape
- Represents: Solid, heavy object

### Paper (📄)
- Style: Flat hand/document shape
- Represents: Flat, covering object

### Scissors (✂️)
- Style: Cutting tool shape
- Represents: Sharp, cutting object

All icons:
- Vector format (XML)
- 24x24dp base size
- Scalable without quality loss
- Tintable for theme support

## Responsive Design

### Small Screens
- Components stack vertically
- Minimum padding maintained
- Text scales appropriately

### Large Screens
- More generous spacing
- Cards expand to comfortable reading width
- Buttons remain readable

### Orientation
- Portrait optimized (primary use case)
- Landscape supported via scrolling

## Accessibility

1. **Content Descriptions**: All icons have proper descriptions
2. **Touch Targets**: Buttons are large enough (120dp height)
3. **Color Contrast**: Material 3 ensures WCAG compliance
4. **Text Sizing**: Respects system font size settings

## Theme Adaptation

### Light Mode
- High contrast for readability
- Soft, welcoming colors
- Clear visual hierarchy

### Dark Mode
- Reduced eye strain
- Elevated surfaces for depth
- Maintains color semantics

### Dynamic Colors
- Personalized experience
- Consistent with system UI
- Maintains accessibility

## Motion & Interactivity

### User Actions
1. **Tap Button**: 
   - Haptic feedback
   - Disabled state transition
   - Game state update

2. **View Result**:
   - Animated reveal
   - Color-coded feedback
   - Score update

3. **New Game**:
   - Clear animations
   - Reset to initial state
   - Re-enable buttons

### Timing
- Button tap → Vibration: Immediate
- Selection → Computer choice: 300ms
- Computer choice → Result: 300ms
- Total round time: ~600ms + user decision time

## Material 3 Components Used

- ✅ FilledTonalButton
- ✅ OutlinedButton
- ✅ Card
- ✅ Surface
- ✅ MaterialTheme
- ✅ Typography
- ✅ ColorScheme
- ✅ Icon
- ✅ Text

## Design Principles Applied

1. **Clarity**: Clear visual hierarchy and purpose
2. **Efficiency**: Quick gameplay without delays
3. **Consistency**: Material 3 throughout
4. **Feedback**: Visual and haptic responses
5. **Delight**: Smooth animations and emojis
6. **Accessibility**: Inclusive design choices

This design creates a modern, engaging, and accessible Rock-Paper-Scissors game that feels native to Android and aligns with Material You principles.
