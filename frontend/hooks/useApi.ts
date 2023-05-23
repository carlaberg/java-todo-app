import { sharedFetch } from "../lib/sharedFetch";
import useSWR from "swr";
import { getIdToken, getAuth } from "firebase/auth";

interface ApiHookResult<UseApiResponse> {
  data: UseApiResponse;
  error: Error;
  isLoading: boolean;
  mutate: () => {};
}

interface UseApiRequest<UseApiRequestBody> {
  path: string;
  body?: UseApiRequestBody;
  method?: string;
}

interface ApiFetcherProps {
  path: string;
  method?: string;
  body?: any;
}

export const apiFetcher = async ({
  path,
  method,
  body,
}: ApiFetcherProps): Promise<any> => {
  const auth = getAuth();
  const token = await getIdToken(auth.currentUser);
  let options: RequestInit = {
    headers: {
      Authorization: `Bearer ${token}`,
      "Content-Type": "application/json",
    },
  };

  if (body) {
    options.body = JSON.stringify(body);
  }
  
  if (method) {
    options.method = method;
  }

  return sharedFetch(`/java-api${path}`, options);
};

export const useApi = <UseApiResponse, UseApiRequestBody = any>({
  path,
}: UseApiRequest<UseApiRequestBody>): ApiHookResult<UseApiResponse> => {
  const { data, error, mutate } = useSWR(path, () => apiFetcher({ path }));
  return { data, error, isLoading: !data && !error, mutate };
};
