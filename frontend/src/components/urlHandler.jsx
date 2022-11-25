// export const fetchWithDelay = (url) => {
//     const promise = new Promise((resolve, reject) => {
//       setTimeout(() => {
//         resolve(fetch(url, {
//           method: 'GET',
//         })
//           .then((response) => response.json()));
//       }, 0)
//     });
  
//     return promise;
//   }