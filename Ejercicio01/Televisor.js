class Televisor {
    #marca;
    #resolucion;
    #tipo;

    constructor(marca = "Sin marca", resolucion = 0, tipo = "Desconocido") {
        this.#marca = marca;
        this.#resolucion = resolucion;
        this.#tipo = tipo;
    }

    toString() {
        return `Televisor [Marca: ${this.#marca}, Resolución: ${this.#resolucion}, Tipo: ${this.#tipo}]`;
    }
}

module.exports = Televisor;