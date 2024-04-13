//
// mouse.h
//

#ifndef __MOUSE_H__
#define __MOUSE_H__

#include <dos.h>

#define LButtonDown (button) (((button) & 0x0001) == 1)
#define RButtonDown (button) (((button) & 0x0002) == 2)
#define MButtonDown (button) (((button) & 0x0004) == 4)

#define FALSE	0
#define TRUE	1
typedef	int		BOOL;

//
// Prototipos das funcoes
//

int InitMouse (void);	// inicializa mouse
void ShowMouse (void);	// mostra cursor do mouse
void HideMouse (void);	// esconde cursor do mouse
void SetMousePos (int x, int y);	// posiciona cursor do mouse

// restinge movimento do mouse
void RestrictMouse (int x1, int y1, int x2, int y2);

// obtem coordenadas e status dos botoes do mouse
void GetMousePos (int *button, int *x, int *y);

// numero de vezes que um botao foi pressionado
int TimesButtonPressed (int nButton);

// altera formato cursor do mouse
void ChangeMouseCursor (int *shape);

/* initialises mouse */
int InitMouse ()
{
	union REGS i, o ;
	i.x.ax = 0;
	int86 (0x33, &i, &o);
	return (o.x.ax);
}

/* displays mouse pointer */ 
void ShowMouse ()
{ 
	union REGS i, o ;
	i.x.ax = 1;
	int86 (0x33, &i, &o);
}

/* hides mouse pointer */
void HideMouse ()
{
	union REGS i, o ;
	i.x.ax = 2;
	int86 (0x33, &i, &o);
}

/* restricts mouse movement */ 
void RestrictMouse (int x1, int y1, int x2, int y2)
{ 
	union REGS i, o ;
	i.x.ax = 7;
	i.x.cx = x1;
	i.x.dx = x2;
	int86 (0x33, &i, &o);

	i.x.ax = 8;
	i.x.cx = y1;
	i.x.dx = y2;
	int86 (0x33, &i, &o);
}

/* gets mouse coordinates and button status */ 
void GetMousePos (int *button, int *x, int *y)
{
	union REGS i, o ;
	i.x.ax = 3;
	int86 (0x33, &i, &o);
	*button = o.x.bx;
	*x = o.x.cx;
	*y = o.x.dx;
}  

/* set mouse coordinates */
void SetMousePos (int x, int y)
{
	union REGS i, o ;
	i.x.ax = 4;
	i.x.cx = x;
	i.x.dx = y;
	int86 (0x33, &i, &o);
}

/* number of times the button was pressed
 * Parameter:
 *		nButton: 0-Left  1-Button  2-Middle
 */
int TimesButtonPressed (int nButton)
{
	union REGS i, o ;
	i.x.ax = 5;
	i.x.dx = nButton;
	int86 (0x33, &i, &o);
	return o.x.bx;
}

void ChangeMouseCursor (int *shape)
{
	union REGS i, o ;
	struct SREGS s;
	i.x.ax = 9 ;  /* service number */ 
	i.x.bx = 0 ;  /* actual cursor position from left */ 
	i.x.cx = 0 ;  /* actual cursor position from top */ 
	i.x.dx = ( unsigned ) shape ;  /* offset address of pointer image */ 
	segread ( &s ) ;  
	s.es = s.ds ;  /* segment address of pointer */ 
	int86x ( 0x33, &i, &i, &s ) ; 
}  

#endif // ifndef __MOUSE_H__
