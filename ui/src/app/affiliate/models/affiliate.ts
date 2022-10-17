import {Address} from './address';

export interface Affiliate {
  code: string;
  nationalNumber: string;
  firstName: string;
  lastName: string;
  email: string;
  phoneNumber: string;
  gender: string;
  birthdate: string;
  addresses: Address[];
}
