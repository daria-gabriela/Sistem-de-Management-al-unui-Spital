# 🏥 Sistem de Management al unui Spital  

## 📌 Descriere  
Acest proiect este o aplicație **Java** care gestionează activitățile unui spital, incluzând **pacienți, medici, consultații și programări**.  
Proiectul este realizat pentru disciplina **Programare Avansată pe Obiecte** și este structurat în două etape:  

- **Etapa I:** Definirea și implementarea conceptului de bază  
- **Etapa II:** Persistență cu **JDBC** și audit al acțiunilor  

---

## 📌 Etapa I: Definirea sistemului și implementare  

### 🔹 1. Obiecte utilizate (minim 8)  
- **Pacient** – reprezintă un pacient al spitalului  
- **Medic** – specialist care efectuează consultații  
- **AsistentMedical** – asistă medicii în tratarea pacienților  
- **Consultatie** – reprezintă o întâlnire dintre un pacient și un medic  
- **ProgramareMedicala** – programare efectuată pentru un pacient la un medic  
- **RetetaMedicala** – rețetă emisă de medic pentru un pacient  
- **SectieMedicala** – secția spitalului unde activează medicii  
- **DosarMedical** – istoricul medical al unui pacient  

### 🔹 2. Acțiuni / Interogări posibile (minim 10)  
✅ **Adăugare pacient nou**  
✅ **Programare consultație pentru un pacient**  
✅ **Afișare programări ale unui medic**  
✅ **Actualizare diagnostic în urma unei consultații**  
✅ **Afișare rețetă pentru un pacient**  
✅ **Anulare programare**  
✅ **Afișare pacienți unui medic**  
✅ **Căutare pacient după CNP**  
✅ **Afișare istoricul medical al unui pacient**  
✅ **Afișare toate consultațiile dintr-o anumită secție**  

---

## 🛠 Implementare în Java (Etapa I)  

### 🔹 Clase și relații între ele  
- `Pacient`  
- `Medic` *(extinde `PersonalMedical`)*  
- `AsistentMedical` *(extinde `PersonalMedical`)*  
- `Consultatie` *(conține `Pacient` și `Medic`)*  
- `ProgramareMedicala` *(conține `Pacient` și `Medic`)*  
- `RetetaMedicala` *(conține `Pacient` și `Medic`)*  
- `SectieMedicala` *(conține lista de medici)*  
- `DosarMedical` *(asociat unui pacient)*  

### 🔹 Utilizare colecții Java  
- `List<ProgramareMedicala>` – pentru gestionarea programărilor  
- `Map<Integer, Pacient>` – pentru pacienți identificați prin ID  
- `TreeSet<Medic>` – pentru sortarea medicilor  

### 🔹 Servicii și metode principale  
- **`SpitalService`** – gestionează operațiile sistemului  
- **`Main`** – punctul de pornire al aplicației  

---

## 📌 Etapa II: Persistență și Audit  

### 🔹 1. Persistență cu JDBC  
- Crearea unei **baze de date relaționale**  
- Implementarea operațiilor **CRUD** pentru cel puțin **4 entități** (`Pacient`, `Medic`, `Consultatie`, `ProgramareMedicala`)  

### 🔹 2. Serviciu de audit  
- 📄 **Înregistrare acțiuni într-un fișier CSV**  
- 🔍 Structură fișier: **`nume_actiune, timestamp`**  

---

## 🔧 Tehnologii utilizate  
- **Java** (Programare Orientată pe Obiecte)  
- **Colecții Java** (`List`, `Set`, `Map`)  
- **Fișiere CSV** (pentru audit)  
- **JDBC** (interacțiune cu baza de date)  

---
