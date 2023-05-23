import "../styles/globals.css";
import Layout from "../components/layout";
import { initializeApp } from "firebase/app";
import { getAuth, onAuthStateChanged } from "firebase/auth";
import { useRouter } from "next/router";
import { useEffect, useState } from "react";

const firebaseConfig = {
  apiKey: "AIzaSyBRCLDnm8TASqFMMr3ioodB3YsEl79oMW0",
  authDomain: "java-todo-app-f3e2b.firebaseapp.com",
  projectId: "java-todo-app-f3e2b",
  storageBucket: "java-todo-app-f3e2b.appspot.com",
  messagingSenderId: "945283206966",
  appId: "1:945283206966:web:dbe49bce094c637e402d97"
};  

const publicPages = [
  "/",
  "/sign-up",
  "/sign-in"
];

const privatePages = [
  "/todos",
];

const app = initializeApp(firebaseConfig);

export const RouteProtector = ({ children }) => {
  const [isAuthorized, setIsAuthorized] = useState(false);
  const router = useRouter();

  useEffect(() => {
    const auth = getAuth();
    const unsubscribe = onAuthStateChanged(auth, (user) => {

      if (!user) {
        router.push("/sign-in");
      } else {
        setIsAuthorized(true);
      }

      return () => unsubscribe()
    });
  }, [isAuthorized, router])
  

  if (!isAuthorized) return null;

  return children;
}

function MyApp({ Component, pageProps }) {
  return (
    <Layout>
        <Component {...pageProps} />;
    </Layout>
  ) 
}

export default MyApp;
