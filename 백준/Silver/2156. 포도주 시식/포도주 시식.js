const input = require('fs').readFileSync(0, 'utf-8')
    .toString().trim().split(/\s/).map(Number);
const [ n, ...wines ] = input;

const dpTable = new Array(n).fill(0);
dpTable[0] = wines[0];
dpTable[1] = wines[0] + wines[1];
dpTable[2] = Math.max(wines[0] + wines[1], wines[0] + wines[2], wines[1] + wines[2]);

for (let i = 3; i < n; i += 1) {
    dpTable[i] = dpTable[i - 1];
    dpTable[i] = Math.max(dpTable[i], wines[i] + dpTable[i - 2]);
    dpTable[i] = Math.max(dpTable[i], wines[i] + wines[i - 1] + dpTable[i - 3]);
}

console.log(dpTable[n - 1]);