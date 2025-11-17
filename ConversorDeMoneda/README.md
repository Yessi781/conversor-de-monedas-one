# Conversor de Monedas (Java)

Aplicación de consola en Java que consume la API de **ExchangeRate-API** para convertir entre distintas monedas.

## Tecnologías utilizadas

- Java 17+
- `java.net.http.HttpClient` (para consumir la API REST)
- Gson (para deserializar JSON)
- API: [ExchangeRate-API](https://www.exchangerate-api.com/)

## Estructura del proyecto

```text
src/
└── com/
    └── conversor/
        ├── Main.java              # Punto de entrada de la aplicación
        ├── domain/
        │   └── Converter.java     # Lógica de conversión de moneda
        ├── model/
        │   └── ExchangeRateResponse.java   # Modelo de la respuesta JSON
        ├── service/
        │   └── CurrencyApiService.java     # Cliente HTTP para la API
        └── ui/
            └── Menu.java          # Menú de consola (interfaz de usuario)
```

## Cómo funciona

1. El usuario ve un menú en consola con varias opciones de conversión:
   - USD → ARS  
   - ARS → USD  
   - USD → BRL  
   - BRL → USD  
   - USD → COP  
   - COP → USD  
2. El usuario elige una opción (1–7).
3. Se solicita el monto a convertir.
4. La aplicación llama a la API de ExchangeRate-API pasando la moneda base.
5. Se obtiene la tasa de conversión para la moneda destino.
6. El resultado se muestra en pantalla junto con la tasa aplicada.

## Configuración de la API Key

En la clase `CurrencyApiService` se define una constante:

```java
private static final String API_KEY = "TU_API_KEY_AQUI";
```

Cámbiala por tu propia API key obtenida en ExchangeRate-API.

También se construye la URL base:

```java
private static final String BASE_URL = "https://v6.exchangerate-api.com/v6/";
```

La URL completa usada es:

```java
String url = BASE_URL + API_KEY + "/latest/" + baseCurrency;
```

## Ejecución del proyecto

1. Clona el repositorio:

```bash
git clone https://github.com/USUARIO/conversor-monedas-java.git
cd conversor-monedas-java
```

2. Asegúrate de tener configurado tu `API_KEY` en `CurrencyApiService`.

3. Compila el proyecto (ejemplo con Maven o desde tu IDE):
   - Desde IDE (IntelliJ IDEA, Eclipse, etc.): crea un proyecto Java, importa el código y agrega la dependencia de Gson.
   - Con Maven, tu `pom.xml` debería incluir algo como:

```xml
<dependency>
    <groupId>com.google.code.gson</groupId>
    <artifactId>gson</artifactId>
    <version>2.11.0</version>
</dependency>
```

4. Ejecuta la clase `Main`:

```bash
java -cp target/clases com.conversor.Main
```

(O desde el botón de “Run” de tu IDE).

## Manejo de errores

En `CurrencyApiService.obtenerTasas` se captura cualquier excepción al consumir la API y se retorna `null`.  
En un futuro se podría mejorar:

- Validando si `data` es `null` antes de convertir.
- Mostrando mensajes de error más descriptivos (por ejemplo, problemas de red, API caída, etc.).

## Posibles mejoras

- Permitir que el usuario escriba cualquier par de monedas (por ejemplo, EUR → JPY) sin limitarlo a un menú fijo.
- Agregar validaciones para entradas no numéricas.
- Internacionalizar los mensajes (ES/EN).
- Crear tests unitarios para `Converter` y `CurrencyApiService`.

## Licencia

Este proyecto se puede usar libremente con fines educativos. Ajusta la licencia según tu necesidad (por ejemplo, MIT, Apache 2.0, etc.).
