import React from 'react';
const table_style = "px-5 text-green-300 font-thin";


export const Row = (commit) => (
  <tr key={commit.id}>
    <td className={table_style}>
      <span>{commit.id}</span>
    </td>
    <td className={table_style}>
      <span>{commit.name}</span>
    </td>
    <td className={table_style}>
      <span>{commit.email}</span>
    </td>
  </tr>
);