<h1 align="center">NOVA per Android</h1>

<p align="center">La dashboard per la scuola: compiti, verifiche, voti, orario, widget e assistente AI.<br>Interfaccia locale con funzioni native Android.</p>

---

## Cos'è NOVA

NOVA riunisce lo studio e le chat con gli amici in un'app: dashboard, calendario, ClasseViva, promemoria e un assistente Groq con la tua chiave. Le schermate sono incluse nell'APK, quindi le modifiche richiedono un aggiornamento dell'app.

## Funzionalità

### Studio

- Compiti e verifiche da ClasseViva, con aggiornamento manuale e controlli periodici soggetti ai limiti Android.
- Compiti manuali, calendario, medie per materia e conto alla rovescia per la prossima verifica.
- Orario settimanale modificabile e widget per lezioni, scadenze e calendario.
- Assistente AI per lo studio, lettura delle foto dell'orario e promemoria, con una tua chiave Groq.

### Amici e profili

- Profili a pagina intera con pulsante Indietro, follower e richieste di amicizia.
- Chat singole e gruppi, foto, vocali, reazioni e indicatore animato quando arriva un segnale reale di scrittura.
- Mappa amici solo con condivisione attivata, modalità fantasma e indicazione dell'ultimo aggiornamento. Il credito OpenStreetMap resta visibile e collegato alla licenza.

### E in più

Tema chiaro/scuro, intro con audio e feedback aptico, meteo, batteria, timer, blocco biometrico e miniplayer Spotify. Spotify richiede Premium e un Client ID personale. Le animazioni e i widget Android non sono identici a quelli iOS.

## Account e privacy

- L'account NOVA può salvare privatamente foto profilo, compiti, voti, conversazione AI, orario e preferenze. I salvataggi hanno controllo di versione e gestione dei conflitti tra dispositivi.
- Password ClasseViva, chiave Groq e token Spotify restano sul telefono, protetti tramite Android Keystore. Non vengono trasferiti dal backup NOVA.
- Permessi del telefono, blocco biometrico, consenso posizione e promemoria del sistema non vengono riattivati automaticamente da un ripristino account.
- Le chat amici sono sul server. La posizione si condivide solo con l'opzione attiva; non è un tracciamento continuo garantito.
- Il backup non è una garanzia contro ogni perdita: prima di uscire verifica **Impostazioni > Account NOVA > Salva ora** e attendi **Salvato nell'account**. La dimensione massima del singolo backup è circa 1,5 MB.

## Installazione e aggiornamento

L'APK di prova firmato viene consegnato direttamente. Questo repository contiene anche archivi e test di sviluppo: non confonderli con l'APK più recente.

1. Apri l'APK ricevuto e consenti l'installazione da quella fonte, se Android lo chiede.
2. Aggiorna **sopra l'app esistente**, senza disinstallarla e senza cancellare i dati.
3. Per mantenere gli aggiornamenti compatibili deve essere usata la stessa chiave di firma.

Pacchetto: `site.federicotaranu.nova`. Minimo dichiarato: Android 8.0 / API 26. La compatibilità su ogni modello non è garantita; le verifiche eseguite non sostituiscono la prova sul telefono.

## Limiti noti

- Notifiche chat tramite ntfy: serve la configurazione separata e la ricezione sul telefono non è ancora confermata; l'ultimo test dal servizio ha incontrato un limite di invio. Non considerarle un canale affidabile per urgenze.
- Risparmio energetico, permessi notifiche e sveglie esatte possono ritardare o impedire promemoria e aggiornamenti in background.
- Accesso Google non ancora configurato; accesso Apple non incluso nella configurazione gratuita.
- Le credenziali dei servizi vanno inserite di nuovo su un altro dispositivo.
- I widget e il ponte nativo sono stati verificati in test mirati; GPS, notifiche e comportamento della tastiera dipendono anche dal dispositivo e dai permessi.

## Build

Il progetto usa Java e Android SDK. La chiave di firma e il file della password non appartengono al repository. La build richiede i percorsi privati `NOVA_KEYSTORE` e `NOVA_KEYPASS_FILE`.

Gli archivi storici e i test presenti qui non costituiscono una pubblicazione automatica della versione più recente. Gli aggiornamenti dell'interfaccia inclusa nell'APK richiedono una nuova installazione in-place.
