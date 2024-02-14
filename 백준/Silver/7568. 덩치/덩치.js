const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');
const [ n, ...personStrArr ] = input;
const personArr = personStrArr.map((str) => str.trim().split(' ').map(Number));

const rating = personArr
    .map(([ targetKG, targetCM ], _idx, src) => src
    .filter(([ KG, CM ]) => KG > targetKG && CM > targetCM).length + 1)
    .join(' ');

console.log(rating);