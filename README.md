# Adivina el número con sockets TCP

Juego cliente/servidor. El servidor genera un número secreto entre 1 y 100 por cada cliente. El cliente envía intentos y el servidor responde `MAYOR`, `MENOR` o `CORRECTO`.

## Estructura

```
src/adivina/
├── ServidorAdivina.java
└── ClienteAdivina.java
```

## Ejecución

1. Ejecutar primero `ServidorAdivina`.
2. Ejecutar `ClienteAdivina` y escribir números. Desde terminal :

## Notas

- El servidor debe arrancar antes que el cliente.
- Atiende un cliente cada vez.
- Puerto: 5000.
- El servidor cierra la conexión tras acertar y vuelve a esperar a otro cliente.


ayuda
