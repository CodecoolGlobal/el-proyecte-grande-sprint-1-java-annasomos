import React, {useState, useEffect} from 'react';
import List from './List';

const pubs = () => {
  const PUBS_API_URL = '/pubsapi';
  const [requestType, setRequestType] = React.useState('pubs');
  const [pubs, setPubs] = useState({});

  useEffect(async () => {
    const fetchPubs = async () => {
      try {
        const response = await fetch(`${PUBS_API_URL}${requestType}`);
        const data = await response.json();
        setPubs(data);
      } catch (err) {
        if (!response) return err;
      }
    };
  });
  return (
    <List Listdata={JSON.stringify(pubs)}/>
  );
};

const apiRequestPubList = async (
  url = '',
  opsionsObj = null,
  errorMessage = null
) => {
  try {
    const response = await fetch(url, opsionsObj);
    if (!response.ok) throw Error('Please reload the app');
  } catch (err) {
    errorMessage = err.message;
  } finally {
    return errorMessage;
  }
};

export default pubs;
