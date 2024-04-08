const n = Number(require('fs').readFileSync(0, 'utf-8').toString());

const dpTable = new Array(1000001).fill(0);
dpTable[1] = 1;
dpTable[2] = 2;

for (let i = 3; i <= n; i += 1) {
    dpTable[i] = (dpTable[i - 1] + dpTable[i - 2]) % 15746;
}

console.log(dpTable[n]);