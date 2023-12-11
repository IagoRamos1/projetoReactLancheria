import React, { useEffect, useState } from 'react';
import { fetchGitHubUser } from '../../Services/ClientService';

interface GitHubUserProps {
  username: string;
}

const GitHubUser: React.FC<GitHubUserProps> = ({ username }) => {
  const [userData, setUserData] = useState<any | null>(null);
  const [loading, setLoading] = useState<boolean>(true);
  const [error, setError] = useState<string | null>(null);

  
  useEffect(() => {
    fetchGitHubUser(username)
      .then(response => {
        setUserData(response.data);
        setLoading(false);
      })
      .catch(err => {
        setError(err.message || 'Something went wrong');
        setLoading(false);
      });
  }, [username]);

  if (loading) return <div>Loading...</div>;
  if (error) return <div>Error: {error}</div>;

  return (
    <div>
      <img src={userData?.avatar_url} alt={`${username}'s avatar`} width={100} />
      <h1>{userData?.name || userData?.login}</h1>
      <p>{userData?.bio}</p>
      <p><a href={userData?.html_url} target="_blank" rel="noopener noreferrer">GitHub Profile</a></p>
    </div>
  );
}

export default GitHubUser;
