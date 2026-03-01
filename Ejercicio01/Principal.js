const Anime = require('./Anime.js');
const Televisor = require('./Televisor.js');
const Instrumento = require('./Instrumento.js');

const anime1 = new Anime("Solo Leveling", "Acción/Fantasía", 12);
const anime2 = new Anime("Death Note", "Thriller", 37);

const tv1 = new Televisor("Samsung", 4000, "oled");
const tv2 = new Televisor();

const inst1 = new Instrumento("Guitarra", "Madera", "cuerda");
const inst2 = new Instrumento("Flauta", "Metal", "aire");

console.log(tv1.toString());
console.log(inst1.toString());