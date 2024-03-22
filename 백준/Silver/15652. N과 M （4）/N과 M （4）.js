const input = require('fs').readFileSync(0, 'utf-8')
    .toString().trim().split(/\s/).map(Number);
const [ n, m ] = input;

const intArr = Array.from({ length: n }, (_, i) => i + 1);
const selected = [];

const answer = [];
const dfs = (arr, depth = 0, start = 0) => {
    if (depth === m) {
        const result = selected.map((i) => arr[i]).join(' ');
        answer.push(result);
        return;
    }
    for (let i = start; i < arr.length; i += 1) {
        selected.push(i);
        dfs(arr, depth + 1, i);
        selected.pop();
    }
}
dfs(intArr);
console.log(answer.join('\n'));