# Changelog

## Versjon 6 – 2026-11-16

### Lagt til
- Egne hurtigvarer: trykk **✎ Rediger** for å legge til, endre navn på, fjerne og flytte dem (dra og slipp).
- **Fjern alle** hurtigvarer, med bekreftelse.
- Maks 30 hurtigvarer og 30 tegn per navn, og samme vare kan ikke legges inn to ganger.

### Endret
- Appen starter uten forhåndsvalgte hurtigvarer. En tom liste viser «+ Legg til en vare med «Rediger»».
- Tilbake-knappen på Android avslutter redigering av hurtigvarer før den lukker appen.

## Versjon 5 – 2026-11-16

Første versjon for Google Play.

### Lagt til
- Personvernerklæring på norsk og engelsk (`personvern.html`), publisert på GitHub Pages.
- Signering med opplastingsnøkkel og bygg av AAB for Google Play.

### Endret
- Pakkenavnet er nå `no.itproas.handleliste`, slik Google Play krever. Appen installeres som en ny app, så lister i den gamle versjonen følger ikke med.
- Versjonsnummeret er nå ett tall som øker med 1 for hver versjon. Versjon 5 kommer etter v0.2.0.

### Fjernet
- Gammel kode for lagring utenfor enheten, som aldri var i bruk i appen eller på nettsiden. Lista lagres fortsatt bare lokalt.

## v0.2.0 – 2026-10-31

### Lagt til
- **Fjern alt**-knapp i «Å kjøpe» som tømmer hele lista, også handlekurven.
- Bekreftelse før lista slettes, med antall varer som forsvinner.
- README forklarer advarselen fra Google Play Protect.

### Endret
- Appen heter nå **Handleliste**. Overskriften inne i appen følger fortsatt valgt språk.
- **Fjern alt** og **Tøm** er lettere å treffe.

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
