class Anime {
    nombre;
    genero;
    #nroEpisodios;
    #episodios;

    constructor(nombre, genero, nroEpisodios) {
        this.nombre = nombre;
        this.genero = genero;
        this.#nroEpisodios = nroEpisodios;
        this.#episodios = new Array(nroEpisodios);
    }
}

module.exports = Anime;