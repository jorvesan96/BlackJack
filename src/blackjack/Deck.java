package blackjack;

import java.util.Random ;
public class Deck {
	
	private Cards[] cardsInDeck;
	private int numOfCardsInDeck;
	private int onePack = 52;
	
	public Deck(){
		
		this(1, true);
	}
	
	public Deck(int numPacks, boolean shuffle){
		
		this.numOfCardsInDeck = numPacks*this.onePack;
		this.cardsInDeck = new Cards[this.numOfCardsInDeck];
		
		int c = 0;
		
		for(int d=0;d<numPacks;d++){
			
			for(int s=0; s<4;s++){
				
				for(int n=1;n<=13;n++){
					
					this.cardsInDeck[c] = new Cards(Suits.values()[s], n);
					c++;
				}
			}
		}
		
		if(shuffle){
			
			this.shuffleDeck();
		}
	}
	
	
	public void shuffleDeck(){
		
		Random rng = new Random();
		
		Cards temp;
		
		
		int j;
		for(int i=0; i<this.numOfCardsInDeck;i++){
			
			j = rng.nextInt(this.numOfCardsInDeck);
			
			temp = this.cardsInDeck[i];
			this.cardsInDeck[i] = this.cardsInDeck[j];
			this.cardsInDeck[j] = temp;	
		}
	}
	
	
	public Cards dealingNextCard(){
		
		Cards topCard = this.cardsInDeck[0];
		
		
		for(int c =1; c<this.numOfCardsInDeck;c++){
			
			this.cardsInDeck[c-1] = this.cardsInDeck[c];
		}
		
		this.cardsInDeck[this.numOfCardsInDeck - 1] = null;
		this.numOfCardsInDeck--;
		 
		return topCard;
	}
	
	public void printDeckCards(int num){
		
		for(int c=0; c<num; c++){
			
			System.out.printf("% 3d/%d %s\n", c+1, this.numOfCardsInDeck, this.cardsInDeck[c].toString());
		}
		
		System.out.printf("\t\t[%d other]\n", this.numOfCardsInDeck - num);
	}
}
