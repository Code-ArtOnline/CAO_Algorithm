const fs = require('fs');
const n = Number(fs.readFileSync('/dev/stdin').toString().trim());

function calcDelivery(n) {
    const deliverySteps = (n, cnt) => {
        if (n === 0 || n % 5 === 0) {
            return cnt + parseInt(n / 5);
        }
        if (n < 0) return undefined;
        return deliverySteps(n - 3, cnt + 1);
    };

    return deliverySteps(n, 0) ?? -1;
}

const result = calcDelivery(n);
console.log(result);
