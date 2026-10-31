# Shopping list

En enkel handleliste som virker uten nett. Lista lagres bare på telefonen din.

- **Android:** app som installeres fra en APK-fil.
- **iPhone:** nettside som legges til på Hjem-skjermen: https://keilen10.github.io/shopping-list/

Se [CHANGELOG.md](CHANGELOG.md) for hva som er endret i hver versjon.

## iPhone

APK-filen virker ikke på iPhone. Bruk nettsiden i stedet:

1. Åpne https://keilen10.github.io/shopping-list/ i **Safari** mens du har nett.
2. Trykk på **Del-knappen** (firkanten med pil opp).
3. Velg **Legg til på Hjem-skjerm**, og trykk **Legg til**.
4. Åpne appen fra det nye ikonet én gang mens du har nett, så filene blir lagret.

Etter dette kan du bruke den uten nett.

Bruk alltid ikonet på Hjem-skjermen. Safari og Hjem-skjerm-appen kan ha hver sin lagring, så en liste du lager i Safari vises kanskje ikke i appen.

Lista finnes bare på denne telefonen. Den blir ikke delt med andre enheter, og den forsvinner hvis du sletter appen fra Hjem-skjermen.

## Android

1. Last ned APK-filen fra [Releases](https://github.com/Keilen10/shopping-list/releases) på telefonen.
2. Trykk på filen, og tillat installasjon fra ukjente kilder hvis du blir spurt.
3. Åpne **Shopping list**.

Appen trenger ikke internett og ber ikke om noen tillatelser.

## Bygge APK-en

Du trenger JDK 17 eller nyere og Android SDK (`platforms;android-36` og `build-tools;36.0.0`). Sett `JAVA_HOME`, og oppgi SDK-mappen som `sdk.dir` i `local.properties`.

Kjør dette fra denne mappen:

```bash
.\gradlew.bat assembleDebug
```

APK-en havner i `app/build/outputs/apk/debug/app-debug.apk`.

## Lage en ny versjon

1. Gjør endringene i `app/src/main/assets`. Android-appen og nettsiden bruker de samme filene.
2. Endre versjonsnummeret i `app/src/main/assets/version.js`. Android-appen, innstillingspanelet og nettsiden henter det derfra.
3. Øk `versionCode` med 1 i `app/build.gradle.kts`. Ellers kan ikke Android oppdatere appen.
4. Skriv endringene i `CHANGELOG.md`.
5. Bygg APK-en, og legg den ved en ny [GitHub Release](https://github.com/Keilen10/shopping-list/releases).
6. Last opp endringene til `main`. Nettsiden publiseres av seg selv når filene i `app/src/main/assets` endres.

## Filer

| Plassering | Innhold |
| --- | --- |
| `app/src/main/assets/` | Selve handlelista, ikoner, manifest og service worker |
| `app/src/main/java/` | Android-appen (Kotlin, én Activity med WebView) |
| `.github/workflows/pages.yml` | Publiserer nettsiden til GitHub Pages |
