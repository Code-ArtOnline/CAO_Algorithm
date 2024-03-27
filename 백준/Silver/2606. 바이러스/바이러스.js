const input = require('fs').readFileSync(0, 'utf-8')
    .toString().trim().split('\n').map(str => str.trim().split(/\s/).map(Number));
const [ ,, ...computers ] = input;

const networks = computers
    .reduce((obj, [ a, b ]) => {
        obj[a] = obj[a] ? [...obj[a], b] : [b];
        obj[b] = obj[b] ? [...obj[b], a] : [a];
        return obj;
    }, {});

let cnt = 0;
const dfs = (graph, node, visited = new Set()) => {
    if (visited.has(node)) return;
    visited.add(node);
    cnt += 1;
    graph[node]?.forEach((v) => {
        dfs(graph, v, visited);
    });
}
dfs(networks, 1);

console.log(cnt - 1);