# Changelog

## v0.1.0 – 2026-10-31

### Lagt til
- Innstillingspanel som åpnes med et tannhjul øverst til høyre.
- Valg av språk (norsk eller engelsk). Første gang følger appen språket på telefonen.
- Valg av utseende (System, Lys eller Mørk).
- Versjonsnummeret vises i innstillingene.

### Endret
- Nytt app-ikon: en enkel handleliste.
- Android: tilbake-knappen lukker innstillingspanelet før den lukker appen.
- Android: statuslinjen og bakgrunnen følger valgt tema.
- Versjonsnummeret står nå bare i `version.js`.

## v0.0.1 – 2026-10-31

### Lagt til
- Støtte for å legge handlelista til på Hjem-skjermen på iPhone (web-manifest, Apple-metatagger og app-ikoner).
- Service worker, så nettversjonen virker uten nett etter første besøk.
- `index.html`, som sender besøkende videre til `shopping-list.html`.
- Nettversjonen er publisert på https://keilen10.github.io/shopping-list/.

### Endret
- Android: `versionName` er nå `0.0.1` og `versionCode` er `2`, så APK-en kan installeres over forrige bygg.
- Hele prosjektet ligger nå i GitHub-repoet, APK-en publiseres som GitHub Release, og nettsiden publiseres fra `app/src/main/assets` med GitHub Actions.

## Første bygg – 2026-10-31

Android `versionName` `1.0`, `versionCode` `1`.

### Lagt til
- Android-app med én Activity og WebView som laster siden fra appens assets, uten internett-tillatelse.
- Lagring av lista i `localStorage`, som lagrer med en gang en vare endres.
- Plass til statuslinje, navigasjonslinje og tastatur, app-ikon og tema som følger telefonen.

### Endret
- Fjernet Google Fonts og byttet til systemfonten.
