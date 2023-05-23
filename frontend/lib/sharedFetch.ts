export const sharedFetch = async <ResponseType = any>(url: string, options: RequestInit): Promise<ResponseType> => {
    const result = await fetch(url, options);
    const isJson = result.headers.get("content-type") === "application/json";
    
    if (isJson) {
        const parsedResponse = await result.json() as Promise<ResponseType>;
        return parsedResponse;
    };
}