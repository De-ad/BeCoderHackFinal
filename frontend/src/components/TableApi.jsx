import { fetchWithDelay } from './Fetch.jsx';
const url = 'http://localhost:8082/hello';

const fetchUsers = (plus_url) => fetchWithDelay(url + '?url=' + plus_url);

export const tableAPI = {
  fetchUsers
};