const input = require('fs').readFileSync('/dev/stdin').toString().trim().split('\n');
const [ n, ...str ] = input.map(str => str.trim());
const [ h, a ] = str.map(str => str.split(' ').map(Number));

const targetTrees = h.map((tree, i) => [ tree, a[i] ]).sort(([, a], [, b]) => a - b);
const amount = targetTrees
    .reduce((amt, [ tree, growth ], i) => amt + tree + (growth * i), 0);

console.log(amount);