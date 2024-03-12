const input = require('fs').readFileSync(0, 'utf-8')
    .toString().trim().split('\n')
    .map(str => str.trim().split(' ').map(Number));
const result = input
    .reduce((arr, target) => (target.length > 1 ? (arr.push(target), arr) : arr), [])
    .map((dailyPrice) => {
        const [ profit ] = dailyPrice.reverse().reduce(([ profit, max ], price) => {
            if (price > max) return [ profit, price ];
            if (price < max) return [ profit + max - price, max ];
            return [ profit, max ];
        }, [ 0, 0 ]);
        return profit;
    }).join('\n');

console.log(result);