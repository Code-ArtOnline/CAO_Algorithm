const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');
const [ strCondition, ...strCables ] = input;
const [ k, n ] = strCondition.split(' ').map(Number);
const cables = strCables.map(Number);

let start = 1;
let end = Math.max(...cables);

let unit = 0;
while (start <= end) {
    const mid = parseInt((start + end) / 2);
    const expectedCount = cables.reduce((count, cable) => {
        return count + parseInt(cable / mid);
    }, 0);
    if (expectedCount < n) { end = mid - 1 }
    else { unit = mid; start = mid + 1 }
}

console.log(unit);