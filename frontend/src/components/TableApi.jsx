import { fetchWithDelay } from './Fetch.jsx';
const url = 'http://localhost:8082/hello';

const fetchUsers = () => fetchWithDelay(url);

export const tableAPI = {
  fetchUsers
};