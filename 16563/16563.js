//문제: 16563
const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
let input = fs.readFileSync(filePath).toString().trim().split("\n");

solution(input);
function solution(input) {
  let n = input.shift() * 1;
  const num_arr = input[0].split(" ").map(Number);

  num_arr.forEach((e) => {
    let i = 2;
    let result = "";
    while (e > 3) {
      if (e % 2 === 0) {
        result += "2 ";
        e /= 2;
      } else if (e % i === 0) {
        result += `${i} `;
        e /= i;
        i = 2;
      } else i++;
    }
    if (e === 2) result += "2";

    console.log(result.trim());
  });
}
