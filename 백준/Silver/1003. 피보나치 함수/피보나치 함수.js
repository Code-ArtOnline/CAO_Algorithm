const input = require('fs').readFileSync(0, 'utf-8')
    .toString().trim().split(/\s/).map(Number);
const [ t, ...testCase ] = input;

const dpTable = new Array(100).fill(0);
dpTable[0] = 0;
dpTable[1] = 1;

for (let i = 2; i <= 40; i += 1) {
    dpTable[i] = dpTable[i - 1] + dpTable[i - 2];
}

testCase.forEach((n) => {
    if (n === 0) console.log(1, 0);
    else console.log(dpTable[n - 1], dpTable[n]);
});