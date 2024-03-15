const input = require('fs').readFileSync(0, 'utf-8')
    .toString().trim().split(/\s/).map(str => str.trim().split(''));
const [ [ n ], ...words ] = input;

const digitOfWords = words.reduce((map, spelling) => {
    spelling.forEach((txt, i, src) => {
        const value = Math.pow(10, src.length - i - 1);
        map.set(txt, (map.get(txt) ?? 0) + value);
    });
    return map;
}, new Map());

const result = [ ...digitOfWords ]
    .sort(([, a], [, b]) => b - a)
    .reduce((sum, [ _, digits ], i) => sum + (digits * (9 - i)), 0);

console.log(result);