const input = require('fs').readFileSync('/dev/stdin')
    .toString().trim().split('\n').map(Number);
const [ n, ...targetArr ] = input;

console.log(targetArr.sort((a, b) => a - b).join('\n'));