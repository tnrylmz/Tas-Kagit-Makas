# Taş Kağıt Makas (Rock Paper Scissors)

Modern bir Android uygulaması - Material 3 (Material You) tasarım diliyle geliştirilmiş klasik Taş-Kağıt-Makas oyunu.

## 🎮 Özellikler

- **Material 3 Tasarım**: Material You komponent ve renk şeması kullanılarak modern bir görünüm
- **Dinamik Tema**: Koyu/açık tema desteği ve Android 12+ cihazlarda dinamik renk desteği
- **Haptic Feedback**: Oyun etkileşimlerinde titreşimli geri bildirim
- **Animasyonlar**: Yumuşak ve akıcı geçiş animasyonları
- **Responsive Tasarım**: Tüm ekran boyutlarına uyumlu arayüz
- **Modern İkonlar**: Vektörel, net ve anlaşılır oyun ikonları
- **Skor Takibi**: Oyuncu ve bilgisayar skorlarının anlık takibi

## 🏗️ Mimari

Uygulama modern Android geliştirme pratiklerine uygun olarak geliştirilmiştir:

- **Kotlin**: %100 Kotlin ile yazılmış
- **Jetpack Compose**: Deklaratif UI framework
- **MVVM Pattern**: Model-View-ViewModel mimari deseni
- **State Management**: Kotlin Flow ile reaktif state yönetimi
- **Material 3**: En güncel Material Design bileşenleri

## 📁 Proje Yapısı

```
app/src/main/java/com/tnrylmz/taskagitmakas/
├── model/
│   ├── GameChoice.kt      # Oyun seçenekleri (TAŞ, KAĞIT, MAKAS)
│   └── GameResult.kt      # Oyun sonuçları (KAZANDI, KAYBETTİ, BERABERE)
├── viewmodel/
│   └── GameViewModel.kt   # Oyun state yönetimi ve mantığı
├── ui/
│   ├── screens/
│   │   └── GameScreen.kt  # Ana oyun ekranı
│   └── theme/
│       ├── Color.kt       # Renk tanımlamaları
│       ├── Theme.kt       # Material 3 tema konfigürasyonu
│       └── Type.kt        # Tipografi ayarları
└── MainActivity.kt        # Ana aktivite
```

## 🎯 Oyun Mantığı

Klasik Taş-Kağıt-Makas kuralları:
- 🪨 **Taş** makası kırar
- 📄 **Kağıt** taşı sarar
- ✂️ **Makas** kağıdı keser

## 🛠️ Gereksinimler

- Android Studio Hedgehog (2023.1.1) veya üzeri
- Android SDK 36
- Minimum API Level 24 (Android 7.0)
- Kotlin 2.0.21

## 📦 Kurulum

1. Projeyi klonlayın:
```bash
git clone https://github.com/tnrylmz/Tas-Kagit-Makas.git
```

2. Android Studio'da açın

3. Gradle senkronizasyonunu bekleyin

4. Uygulamayı çalıştırın

## 🧪 Testler

Proje, oyun mantığını doğrulayan unit testler içerir:

```bash
./gradlew test
```

Test dosyaları:
- `GameLogicTest.kt`: Oyun kurallarının doğruluğunu test eder

## 🎨 Tasarım Kararları

### Material 3 Bileşenleri
- **FilledTonalButton**: Oyun seçim butonları için
- **Card**: Skor tablosu, seçim kartları ve sonuç ekranı için
- **Surface**: Ana arka plan yüzeyi
- **MaterialTheme**: Tutarlı renk ve tipografi için

### Animasyonlar
- **ScaleIn/ScaleOut**: Seçim kartları ve sonuç için
- **FadeIn/FadeOut**: Yumuşak geçişler için
- **Spring Animation**: Doğal ve canlı hareketler için

### Renk Şeması
- **Dynamic Colors**: Android 12+ cihazlarda sistem renklerini kullanır
- **Light/Dark Theme**: Otomatik tema geçişi
- **Semantic Colors**: Material 3 semantik renk sistemini kullanır

## 🔐 İzinler

- `VIBRATE`: Haptic feedback için titreşim izni

## 📱 Ekran Görüntüleri

*(Uygulamanın ekran görüntüleri buraya eklenebilir)*

## 🚀 Gelecek Geliştirmeler

- [ ] Sesli efektler
- [ ] Oyun geçmişi
- [ ] Çok oyunculu mod
- [ ] Başarım sistemi
- [ ] İstatistikler ve grafikler
- [ ] Oyun zorluğu seviyeleri

## 📄 Lisans

Bu proje açık kaynak kodlu bir projedir.

## 👨‍💻 Geliştirici

[@tnrylmz](https://github.com/tnrylmz)

## 🙏 Teşekkürler

Modern Android geliştirme topluluğuna ve Material Design ekibine teşekkürler.
