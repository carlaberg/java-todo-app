/** @type {import('next').NextConfig} */
const nextConfig = {
  reactStrictMode: true,
  swcMinify: true,
  async rewrites() {
    console.log(process.env.BACKEND_HOST);
    return [
      {
        source: '/java-api/:path*',
        destination: `${process.env.BACKEND_HOST}/:path*`,
      },
    ]
  },
}

module.exports = nextConfig
