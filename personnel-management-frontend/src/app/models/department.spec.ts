import { Department } from './department';

describe('Department', () => {
  it('should create an instance', () => {
    expect(new Department(0, '', [])).toBeTruthy(); //input all 'empty' for default
  });
});
