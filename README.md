# 📱 ISTAPPP - Sistema de Gestión de Prácticas Pre Profesionales

![Android](https://img.shields.io/badge/Platform-Android-green.svg?style=for-the-badge&logo=android)
![Java](https://img.shields.io/badge/Language-Java-orange.svg?style=for-the-badge&logo=java)
![Gradle](https://img.shields.io/badge/Build-Gradle-blue.svg?style=for-the-badge&logo=gradle)
![Retrofit](https://img.shields.io/badge/Networking-Retrofit2-red.svg?style=for-the-badge)
![SQLite](https://img.shields.io/badge/Database-SQLite-lightgrey.svg?style=for-the-badge&logo=sqlite)
![Status](https://img.shields.io/badge/Status-Active-brightgreen.svg?style=for-the-badge)

**ISTAPPP** es una aplicación móvil nativa desarrollada para dispositivos Android destinada a digitalizar, centralizar y gestionar todo el ciclo de vida de las **Prácticas Pre Profesionales (PPP)** de los estudiantes del **Instituto Superior Tecnológico Azuay (ISTA)**.

---

## 📋 Tabla de Contenidos

1. [Descripción General](#-descripción-general)
2. [Características Principales](#-características-principales)
3. [Estructura del Proyecto](#-estructura-del-proyecto)
4. [Tecnologías y Librerías](#-tecnologías-y-librerías)
5. [Requisitos del Sistema](#-requisitos-del-sistema)
6. [Instalación y Configuración](#-instalación-y-configuración)
7. [Gestión de Anexos PDF](#-gestión-de-anexos-pdf)
8. [Contribución y Soporte](#-contribución-y-soporte)

---

## 🔍 Descripción General

La aplicación **ISTAPPP** proporciona a la comunidad académica una herramienta intuitiva que conecta a los estudiantes en proceso de prácticas con las convocatorias, documentos normativos y fases institucionales requeridas para completar satisfactoriamente su periodo de formación práctica.

El sistema se estructura en tres etapas fundamentales del proceso de prácticas:
- **Etapa de Inicio:** Registro, verificación de requisitos, asignación de carrera y completado de anexos iniciales.
- **Etapa de Desarrollo:** Registro de actividades, bitácoras de campo y supervisión académica.
- **Etapa Final:** Evaluación de desempeño, informe final y convalidación de horas de práctica.

---

## ✨ Características Principales

* 🔑 **Autenticación de Usuarios:** Control de acceso seguro mediante credenciales de usuario e integración con **Google Sign-In**.
* 📄 **Visualizador de Anexos Oficiales (PDF):** Integración directa del visor de PDFs (`AndroidPDFViewer`) para lectura y diligenciamiento de los 15 anexos normativos oficiales.
* 📢 **Gestión y Notificación de Convocatorias:** Listado de convocatorias activas para prácticas pre profesionales con notificaciones locales del sistema.
* 💾 **Persistencia de Datos Híbrida:** 
  * **Local:** Almacenamiento y almacenamiento en SQLite (`PracticasISTA.db`) a través de helper personalizado (`BaseSQLHelper`).
  * **Remota:** Comunicación sincrónica/asincrónica con API REST backend vía **Retrofit 2** y **Gson**.
* 🎨 **Interfaz de Usuario Material Design:** Diseño adaptativo con soporte para Navigation Drawer, Bottom Navigation, ViewBinding y animaciones fluidas.

---

## 📂 Estructura del Proyecto

```text
com.g2c2.istappp
 ├── 📁 adapter          # Adaptadores para componentes como RecyclerView (ej. Convocatorias)
 ├── 📁 anexos           # Controladores y lógica específica para la gestión de Anexos (1 al 15)
 ├── 📁 intefaces        # Endpoints e interfaces API de Retrofit (Usuario, Carrera, Convocatoria, etc.)
 ├── 📁 login            # Fragmentos y ViewModels para la autenticación de usuarios
 ├── 📁 model            # Clases POJO y BaseSQLHelper para almacenamiento local
 ├── 📁 notify           # Generación de notificaciones del sistema
 ├── 📁 ui               # Módulos de interfaz principal (Home, Gallery, Slideshow)
 ├── 📄 MainActivity     # Actividad contenedora del flujo inicial
 └── 📄 SistemaActivity  # Actividad principal con menú lateral y navegación completa
```

### 📁 Recursos y Assets
* `assets/Anexos/`: Contiene los documentos base en formato `.pdf` (`Anexo1.pdf` al `Anexo15.pdf`).
* `assets/PracticasISTA.db`: Base de datos inicial SQLite prepoblada con la estructura del instituto.

---

## 🛠️ Tecnologías y Librerías

* **Lenguaje:** Java 8 (Compatibilidad Android Source Level 1.8)
* **SDK objetivo:** Android 12 (API level 31)
* **SDK mínimo:** Android 7.0 (API level 24 - Nougat)
* **Componentes Jetpack:**
  * ViewBinding
  * Navigation Component (`navigation-fragment`, `navigation-ui`)
  * LiveData & ViewModel (`lifecycle-ktx`)
* **Librerías de terceros:**
  * **Retrofit 2 & Gson Converter:** Cliente HTTP para interacción RESTful API.
  * **Glide:** Carga y caché eficientes de imágenes.
  * **Android PDF Viewer (`barteksc`):** Renderizado interactivo de PDFs en la aplicación.
  * **Google Play Services Auth:** Autenticación delegada mediante cuentas de Google.

---

## 💻 Requisitos del Sistema

Para compilar y ejecutar este proyecto localmente se necesita:

* **Android Studio:** Bumblebee | Chipmunk | Electric Eel (o superior)
* **JDK:** Java Development Kit 8 u 11
* **Gradle:** 7.x (incluido mediante Gradle Wrapper `gradlew`)
* **Dispositivo Físico o Emulador:** Android 7.0 (API 24) o superior con Google Play Services.

---

## 🚀 Instalación y Configuración

1. **Clonar el repositorio:**
   ```bash
   git clone https://github.com/Daniiel-Hub123/ISTAPPP.git
   cd ISTAPPP
   ```

2. **Abrir en Android Studio:**
   * Selecciona `File > Open...` y escoge la carpeta raíz del proyecto.
   * Deja que Gradle sincronice las dependencias automáticas.

3. **Compilar y Ejecutar:**
   * Conecta un dispositivo Android mediante Depuración USB o inicia un emulador AVD.
   * Haz clic en **Run 'app'** (`Shift + F10`).

---

## 📑 Gestión de Anexos PDF

La app incluye el paquete completo de documentación requerida por el reglamento institucional:

| Anexo | Descripción |
| :--- | :--- |
| **Anexo 1 - 3** | Solicitud de prácticas, ficha de inscripción y carta de compromiso |
| **Anexo 4 - 7** | Cartas de presentación, aceptación y plan de actividades |
| **Anexo 8 - 11** | Bitácoras periódicas y registros de asistencia acumulada |
| **Anexo 12 - 15** | Informe final del estudiante, evaluación del tutor empresarial y certificado de culminación |

---

## 👤 Institución y Licencia

Desarrollado para la comunidad del **Instituto Superior Tecnológico Azuay (ISTA)**.

* **Repositorio:** [Daniiel-Hub123/ISTAPPP](https://github.com/Daniiel-Hub123/ISTAPPP)
