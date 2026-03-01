class Instrumento {
    nombre;
    #material;
    #tipo;

    constructor(nombre, material, tipo) {
        this.nombre = nombre;
        this.#material = material;
        this.#tipo = tipo;
    }

    get material() {
        return this.#material;
    }

    set material(nuevoMaterial) {
        this.#material = nuevoMaterial;
    }

    get tipo() {
        return this.#tipo;
    }

    set tipo(nuevoTipo) {
        this.#tipo = nuevoTipo;
    }

    toString() {
        return `Instrumento [Nombre: ${this.nombre}, Material: ${this.#material}, Tipo: ${this.#tipo}]`;
    }
}

module.exports = Instrumento;