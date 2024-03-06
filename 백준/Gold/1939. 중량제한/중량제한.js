const input = require('fs').readFileSync('/dev/stdin').toString().trim().split('\n');
const [ [ n, m ], ...infos ] = input.map(str => str.trim().split(' ').map(Number));
const [ targetFrom, targetTo ] = infos.pop();

const [ bridges, maxWeight ] = infos.reduce(
    ([ bridges, maxWeight ], [ from, to, weight ]) => {
        bridges[from].push([ to, weight ]);
        bridges[to].push([ from, weight ]);
        return [ bridges, (weight > maxWeight ? weight : maxWeight) ];
    }, 
    [ Array.from({ length: n + 1 }, () => []), 0 ]
);

const bfs = (testCost) => {
    const visited = new Array(n + 1).fill(false);
    
    const queue = [];
    let headIndex = 0;

    queue.push(targetFrom);
    visited[targetFrom] = true;

    while (headIndex < queue.length) {
        const city = queue[headIndex];

        if (city === targetTo) return true;
        for (let i = 0; i < bridges[city].length; i += 1) {
            const [ targetCity, targetCost ] = bridges[city][i];
            if (!visited[targetCity] && testCost <= targetCost) {
                visited[targetCity] = true;
                queue.push(targetCity);
            }
        }
        headIndex += 1;
    }
    return false;
}

let start = 0;
let end = maxWeight;

while (start <= end) {
    const mid = parseInt((start + end) / 2);
    bfs(mid) ? (start = mid + 1) : (end = mid - 1);
}

console.log(end);