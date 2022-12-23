export default {
  preset: 'ts-jest',
  testEnvironment: 'jsdom',
  testPathIgnorePatterns: ['/node_modules/'],
  coverageDirectory: './coverage',
  transform: {},
  setupFilesAfterEnv: [
    "@testing-library/jest-dom/extend-expect"
  ]
};