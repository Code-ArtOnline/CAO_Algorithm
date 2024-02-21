const filePath = process.platform == 'linux' ? '/dev/stdin' : './input.txt';
const fs = require('fs');
const input = fs.readFileSync(filePath).toString().trim().split('\n');
const [ t, ...strLogs ] = input;

const minLogsLevel = strLogs
    .reduce((arr, str, i) => {
        if (i % 2 !== 0) { arr.push(str.trim().split(' ').map(Number).sort((a, b) => a - b)) }
        return arr;
    }, [])
    .map((l) => l.reduce((max, log, i, logs) => Math.max(max, Math.abs(log - logs[i + 2] || 0)), 0))
    .join('\n');

console.log(minLogsLevel);