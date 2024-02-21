const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');
const [ n, strCardN, m, strCardM, ] = input;

const keepCard = strCardN.trim().split(' ')
    .reduce((map, card) => (map.set(card, map.get(card) + 1 || 1)), new Map());

const targetCard = strCardM.trim().split(' ')
    .map((card) => keepCard.get(card) || 0).join(' ');

console.log(targetCard);