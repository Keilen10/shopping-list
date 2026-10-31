# Lage en ny versjon

## Versjonsnummer

Bruk formatet `MAJOR.MINOR.PATCH`:

| Del | Når den økes | Eksempel |
| --- | --- | --- |
| PATCH | Feilretting | 0.1.0 → 0.1.1 |
| MINOR | Ny funksjon | 0.1.1 → 0.2.0 |
| MAJOR | Stor endring, eller første ferdige versjon | 0.9.0 → 1.0.0 |

## Steg

1. Gjør endringene i `app/src/main/assets`. Android-appen og nettsiden bruker de samme filene.
2. Endre versjonsnummeret i `app/src/main/assets/version.js`. Android-appen, innstillingspanelet og nettsiden henter det derfra.
3. Øk `versionCode` med 1 i `app/build.gradle.kts`. Ellers kan ikke Android oppdatere appen.
4. Skriv endringene i `CHANGELOG.md`.
5. Bygg APK-en, som beskrevet i [README](README.md#bygge-apk-en).
6. Last opp endringene til `main`. Nettsiden publiseres av seg selv når filene i `app/src/main/assets` endres.
7. Lag en ny [GitHub Release](https://github.com/Keilen10/shopping-list/releases/new) med taggen `v` + versjonsnummeret, og legg ved APK-en. Velg **Pre-release** så lenge appen er under utvikling.
